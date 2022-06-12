
object NoteService : CrudService<Note>{
    var notes = mutableMapOf<Long,Note>()

    override fun add(entity: Note): Long {
        if(notes.containsKey(entity.noteId)) throw ElementExistException("Note already exist!")
        notes[entity.noteId] = entity
        return entity.noteId
    }

    override fun delete(id: Long): Int {
        if(!notes.containsKey(id)) throw NoSuchElementException("No note with such id")
        if(notes[id]!!.isDeleted) throw NoSuchElementException("Note was already deleted")
        notes[id]!!.isDeleted = true
        return 1
    }

    override fun edit(id: Long,text: String): Int {
        if(!notes.containsKey(id)) throw NoSuchElementException("No note with such id")
            notes[id]!!.text = text
            return 1
    }

    override fun getById(id: Long): Note {
        if(notes.containsKey(id)) return notes[id]!!
        else throw NoSuchElementException("No note with such id")
    }

    override fun restore(id: Long): Note {
        if(!notes.containsKey(id)) throw NoSuchElementException("No note with such id")
        if(!notes[id]!!.isDeleted) throw ElementExistException("Note still exist!")
        notes[id]!!.isDeleted = false
        return notes[id]!!
    }

    override fun get(): Map<Long, Note> {
        return notes
    }
}
