import org.junit.Test
import org.junit.Assert.*

class CommentServiceTest {

    private val commentService = CommentService
    private var techDiscussion = Note(18534L,11L,"Rado chips","Chip review",0,0,false)
    private val techComment1 = Comment(techDiscussion,234L,32,"Response",false)


    @Test
    fun commentServiceTestAdd(){
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        val result = commentService.add(techComment1)
        assertEquals(234,result)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestAddNoteIsDeletedException(){
        commentService.comments.clear()
        techDiscussion.isDeleted = true
        commentService.add(techComment1)
    }


    @Test(expected = ElementExistException::class)
    fun commentServiceTestAddCommentExistException() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.add(techComment1)
    }

    @Test
    fun commentServiceTestDelete() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        val result = commentService.delete(234)
        assertEquals(1,result)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestDeleteNoCommentException() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.delete(233)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestDeleteNoteException() {
        commentService.comments.clear()
        commentService.add(techComment1)
        techDiscussion.isDeleted = true
        commentService.delete(234)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestDeleteCommentIsDeletedException() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.delete(234)
        commentService.delete(234)
    }

    @Test
    fun commentServiceTestEdit() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        val result = commentService.edit(234,"Modified text")
        assertEquals(1,result)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestEditNoCommentException() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.edit(235,"Modified text")
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestEditNoNoteException() {
        commentService.comments.clear()
        commentService.add(techComment1)
        techDiscussion.isDeleted = true
        commentService.edit(234,"Modified text")
    }

    @Test
    fun commentServiceTestGetById() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        val result = commentService.getById(234)
        assertEquals(techComment1,result)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestGetByIdNoCommentException() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.getById(235)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestGetByIdDeletedNoteException() {
        commentService.comments.clear()
        commentService.add(techComment1)
        techDiscussion.isDeleted = true
        commentService.getById(234)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestGetByIdDeletedCommentException() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.delete(234)
        commentService.getById(234)
    }

    @Test
    fun commentServiceTestRestore() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.delete(234)
        val result = commentService.restore(234)
        assertEquals(techComment1,result)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestRestoreNoCommentException() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.delete(234)
        commentService.restore(235)
    }

    @Test(expected = NoSuchElementException::class)
    fun commentServiceTestRestoreNoNoteException() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.delete(234)
        techDiscussion.isDeleted = true
        commentService.restore(234)
    }

    @Test(expected = ElementExistException::class)
    fun commentServiceTestRestoreCommentExistException() {
        commentService.comments.clear()
        techDiscussion.isDeleted = false
        commentService.add(techComment1)
        commentService.restore(234)
    }

    @Test
    fun commentServiceTestGet() {
        val result = commentService.get()
        assertEquals(commentService.comments,result)
    }


}