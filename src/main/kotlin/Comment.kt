class Comment(
    val note: Note,
    val commentId: Long,
    val replyTo: Int,
    var message: String,
    var isDeleted: Boolean = false
)