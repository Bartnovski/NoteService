object CommentService : CrudService<Comment> {

    var comments = mutableMapOf<Long, Comment>()

    override fun add(entity: Comment): Long {
        if (entity.note.isDeleted) throw NoSuchElementException("Note was deleted")
        if (comments.containsKey(entity.commentId)) throw ElementExistException("Comment already exist!")
        comments[entity.commentId] = entity
        return entity.commentId
    }

    override fun delete(id: Long): Int {
        if (!comments.containsKey(id)) throw NoSuchElementException("No comment with such id")
        if (comments[id]!!.note.isDeleted) throw NoSuchElementException("Note was deleted")
        if (comments[id]!!.isDeleted) throw NoSuchElementException("This comment is already deleted")
        comments[id]!!.isDeleted = true
        return 1
    }

    override fun edit(id: Long, text: String): Int {
        if (!comments.containsKey(id)) throw NoSuchElementException("No comment with such id")
        if (comments[id]!!.note.isDeleted) throw NoSuchElementException("Note was deleted")
        comments[id]!!.message = text
        return 1
    }

    override fun getById(id: Long): Comment {
        if (!comments.containsKey(id)) throw NoSuchElementException("No comment with such id")
        if (comments[id]!!.note.isDeleted) throw NoSuchElementException("Note was deleted")
        if (comments[id]!!.isDeleted) throw NoSuchElementException("Comment was deleted")
        return comments[id]!!
    }

    override fun restore(id: Long): Comment {
        if (!comments.containsKey(id)) throw NoSuchElementException("No comment with such id")
        if (comments[id]!!.note.isDeleted) throw NoSuchElementException("Note was deleted")
        if (!comments[id]!!.isDeleted) throw ElementExistException("This comment still exist")
        comments[id]!!.isDeleted = false
        return comments.getValue(id)
    }

    override fun get(): Map<Long, Comment> {
        return comments
    }
}
