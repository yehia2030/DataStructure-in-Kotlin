package linkedlist

import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before

import org.junit.Test
import kotlin.test.assertNotNull


class LinkedListTest {

    @Before
    fun setUp() {
    }

    @Test
    fun `new list has 0 size and null first last nodes`() {
        val linkedList = linkedListOf<Int>()
        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")
        assertEquals(linkedList.size(), 0)
        assertEquals(linkedList.firstOrNull, null)
        assertEquals(linkedList.lastOrNull, null)
    }

    @Test
    fun `insert item at first to empty linkedlist first and last should be equal`() {
        val linkedList = linkedListOf<Int>()
        linkedList.insertFirst(10)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size(), 1)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 10)
        assertEquals(linkedList.lastOrNull?.value, 10)
    }

    @Test
    fun `insert item at first to prefilled linkedlist first and last should be different`() {
        val linkedList = linkedListOf<Int>()
        linkedList.insertFirst(10)
        linkedList.insertFirst(20)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size(), 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)

        assertEquals(linkedList.firstOrNull?.value, 20)
        assertEquals(linkedList.lastOrNull?.value, 10)
    }



    @Test
    fun `insert item at end to empty linkedlist first and last should be equal`() {
        val linkedList = linkedListOf<Int>()
        linkedList.insertEnd(10)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size(), 1)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 10)
        assertEquals(linkedList.lastOrNull?.value, 10)
    }

    @Test
    fun `insert item at end to prefilled linkedlist first and last should be different`() {
        val linkedList = linkedListOf<Int>()
        linkedList.insertEnd(10)
        linkedList.insertEnd(20)

        println("LinkedListContent : $linkedList")
        println("first : ${linkedList.firstOrNull}")
        println("last : ${linkedList.lastOrNull}")

        assertEquals(linkedList.size(), 2)
        assertNotNull(linkedList.firstOrNull)
        assertNotNull(linkedList.lastOrNull)
        assertEquals(linkedList.firstOrNull?.value, 10)
        assertEquals(linkedList.lastOrNull?.value, 20)
    }


    @After
    fun tearDown() {
    }
}