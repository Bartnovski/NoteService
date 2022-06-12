interface CrudService<E> {
    fun add(entity: E) : Long
    fun delete(id: Long) : Int
    fun edit(id: Long,text: String) : Int
    fun getById(id: Long) : E?
    fun restore(id: Long) : E
    fun get() : Map<Long,E>
}
