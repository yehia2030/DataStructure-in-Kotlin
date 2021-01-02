package linkedlist

class LinkedCollection<T> private constructor() : MutableLinkedList<T> {

    companion object {

        // ----- new instances ----
        fun <T> newInstance(): LinkedList<T> {
            return LinkedCollection()
        }

        fun <T> newMutableInstance(): MutableLinkedList<T> {
            return LinkedCollection()
        }

        // ----- from default values  ----
        fun <T> from(first: T): LinkedList<T> {
            val firstNode = Linked.Node(first)
            return LinkedCollection(firstNode)
        }

        fun <T> from(first: Linked.Node<T>): LinkedList<T> {
            return LinkedCollection(first)
        }

        fun <T> from(mutableList: MutableLinkedList<T>): LinkedList<T> {
            return LinkedCollection(mutableList)
        }

        fun <T> fromMutable(first: T): MutableLinkedList<T> {
            val firstNode = Linked.Node(first)
            return LinkedCollection(firstNode)
        }

        fun <T> fromMutable(list: LinkedList<T>): MutableLinkedList<T> {
            return LinkedCollection(list)
        }

        fun <T> fromMutable(first: Linked.Node<T>): MutableLinkedList<T> {
            return LinkedCollection(first)
        }
    }

    private constructor(list: LinkedList<T>) : this() {
        var item = list.firstOrNull
        var current = _first
        while (item != null) {
            if (current == null) {
                _first = item.copy()
            } else {
                current.next = item.copy()
                current = current.next
            }
            item = item.next
        }
    }

    private constructor(first: Linked.Node<T>) : this() {
        _first = first.copy()
        var current = _first
        var other = first.next
        while (other != null) {
            current?.next = other.copy()
            current = current?.next
            other = other.next
        }
    }

    private var _first: Linked.Node<T>? = null

    override val firstOrNull: Linked.Node<T>?
        get() = _first

    override val lastOrNull: Linked.Node<T>?
        get() = when (size) {
            0 -> null
            1 -> _first
            else -> {
                var current = _first
                while (current != null) {
                    current = current.next
                }
                current
            }
        }

    override fun toString(): String {
        var current = _first
        var builder = ""
        while (current != null) {
            val value = current.value ?: ""
            builder = "$builder $value"
            current = current.next
        }
        return builder
    }

    override val size: Int
        get() {
            var current = _first
            var size = 0
            while (current != null) {
                ++size
                current = current.next
            }
            return size
        }

    // --------------- Insert --------------------

    override fun insertFirst(data: T) {
        val node = Linked.Node(data)
        node.next = _first
        _first = node
    }

    override fun insertLast(data: T) {
        when (size) {
            0 -> insertFirst(data)
            else -> {
                val node = Linked.Node(data)
                var current = _first
                while (current?.next != null) {
                    current = current.next
                }
                current?.next = node
            }
        }
    }

    override fun insertAt(index: Int, data: T) {
        // val size = size
        // when {
        //     index > size -> throw IndexOutOfBoundsException("Invalid index for Insert")
        //     index == 0 -> insertFirst(data)
        //     index == size -> insertLast(data)
        //     else -> {
        //         val node = Linked.Node(data)
        //         var current = _first
        //         var tailing = _first
        //         var count = 0
        //         while (count != index) {
        //             tailing = current
        //             current = current?.next
        //             ++count
        //         }
        //         tailing?.next = node
        //         node.next = current
        //         current = node
        //     }
        // }
    }

    override fun insertAll(linkedList: LinkedList<T>) {
        // var last = lastOrNull
        // linkedList.forEachNode {
        //     last?.next = it?.copy()
        //     last = last?.next
        // }
    }

    override fun insertAll(list: List<T>) {
        TODO("Not yet implemented")
    }

    // --------------- Delete --------------------

    override fun deleteFirst() {
        // val current = _first ?: return
        // val next = current.next
        // _first = next
    }

    override fun deleteLast() {
        // when (size) {
        //     0, 1 -> deleteFirst()
        //     else -> {
        //         var current = _first
        //         var prev = _first
        //         while (current?.next != null) {
        //             prev = current
        //             current = current.next
        //         }
        //         prev?.next = null
        //     }
        // }
    }

    override fun deleteAt(index: Int) {
        // val size = size
        // when {
        //     index > size -> throw IllegalArgumentException("Invalid index for Deletion")
        //     index == 0 -> deleteFirst()
        //     index == size -> deleteLast()
        //     else -> {
        //         var current = _first
        //         var prev = _first
        //         var position = 0
        //         while (position != index) {
        //             ++position
        //             prev = current
        //             current = current?.next
        //         }
        //         val next = current?.next
        //         prev?.next = next
        //         current = null
        //     }
        // }
    }

    override fun delete(element: T) {
        // var current = _first
        //
        // if (current?.value == element) {
        //     deleteFirst()
        //     return
        // }
        //
        // var prev = _first
        // while (current?.next != null) {
        //     if (current.value == element) {
        //         break
        //     }
        //     prev = current
        //     current = current.next
        // }
        //
        // val next = current?.next
        // prev?.next = next
        // current = null
    }

    // --------------- Update --------------------

    override fun replace(index: Int, data: T) {
        // val size = size
        // when {
        //     size == 0 -> throw IllegalStateException("Cannot update an empty list")
        //     index > size -> throw IllegalArgumentException("Invalid index for update")
        //     index == 0 -> _first?.value = data
        //     else -> {
        //         var current = _first
        //         var count = 0
        //         while (count != index) {
        //             ++count
        //             current = current?.next
        //         }
        //         current?.value = data
        //     }
        // }
    }

    override fun distinct() {

        // var node = _first
        //
        // while (node != null) {
        //
        //     var current = node.next
        //     var tailing = node
        //
        //     while (current != null) {
        //         if (node.value == current.value) {
        //             tailing?.next = current.next
        //         }
        //         tailing = current
        //         current = current.next
        //     }
        //
        //     node = node.next
        // }
    }

    override fun sort(isDescending: Boolean) {
        TODO("Not yet implemented")
    }

    override fun reverse() {
        // var prev: Linked.Node<T>? = null
        // var current: Linked.Node<T>? = _first
        // var next: Linked.Node<T>? = null
        //
        // while (current != null) {
        //     // hold next reference
        //     next = current.next
        //
        //     // break link to next
        //     current.next = null
        //
        //     // point current to previous
        //     current.next = prev
        //
        //     // previous pointer point to the address of current node
        //     // we can directly use that to assign previous
        //     prev = current
        //
        //     // proceed loop
        //     current = next
        // }
        //
        // _first = prev
    }
}
