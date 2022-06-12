import org.junit.Test
import org.junit.Assert.*

class NoteServiceTest {
    private val noteService = NoteService
    private val techDiscussion = Note(18534L,11L,"Radio chips","Chip review",0,0,false)


    @Test
    fun noteServiceTestAdd(){
        noteService.notes.clear()
        val result = noteService.add(techDiscussion)
        assertEquals(11,result)
    }


    @Test(expected = ElementExistException::class)
    fun noteServiceTestAddException() {
        noteService.notes.clear()
        noteService.add(techDiscussion)
        noteService.add(techDiscussion)
    }

    @Test
    fun noteServiceTestDelete() {
        noteService.notes.clear()
        noteService.add(techDiscussion)
        val result = noteService.delete(11L)
        assertEquals(1,result)
    }

    @Test(expected = NoSuchElementException::class)
    fun noteServiceTestDeleteNoNoteException() {
        noteService.notes.clear()
        noteService.delete(10L)
    }

    @Test(expected = NoSuchElementException::class)
    fun noteServiceTestDeleteAlreadyDeletedException() {
        noteService.notes.clear()
        noteService.add(techDiscussion)
        noteService.delete(11L)
        noteService.delete(11L)
    }

    @Test
    fun noteServiceTestEdit() {
        noteService.notes.clear()
        noteService.add(techDiscussion)
        val result = noteService.edit(11L,"Modified topic")
        assertEquals(1,result)
    }

    @Test(expected = NoSuchElementException::class)
    fun noteServiceTestEditException() {
        val noteService = NoteService
        noteService.add(techDiscussion)
        noteService.edit(10L,"Modified topic")
    }

    @Test
    fun noteServiceTestGetById() {
        val noteService = NoteService
        noteService.add(techDiscussion)
        val result = noteService.getById(techDiscussion.noteId)
        assertEquals(techDiscussion,result)
    }

    @Test (expected = NoSuchElementException::class)
    fun noteServiceTestGetByIdException() {
        val noteService = NoteService
        noteService.add(techDiscussion)
        noteService.getById(10L)
    }

    @Test
    fun noteServiceTestRestore() {
        noteService.notes.clear()
        noteService.add(techDiscussion)
        noteService.delete(11L)
        val result = noteService.restore(11L)
        assertEquals(techDiscussion,result)
    }

    @Test(expected = NoSuchElementException::class)
    fun noteServiceTestRestoreNotExistException() {
        noteService.notes.clear()
        noteService.add(techDiscussion)
        noteService.restore(10L)
    }


    @Test(expected = ElementExistException::class)
    fun noteServiceTestRestoreExistException() {
        noteService.notes.clear()
        noteService.add(techDiscussion)
        noteService.restore(11L)
    }

    @Test
    fun noteServiceTestGet() {
        noteService.notes.clear()
        noteService.add(techDiscussion)
        val result = noteService.get()
        assertEquals(noteService.notes,result)
    }
}