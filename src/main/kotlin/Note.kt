
open class Note(
    val ownerId: Long,
    val noteId: Long,
    val title: String,
    var text: String,
    privacy: Int,
    commentPrivacy: Int,
    var isDeleted: Boolean = false
) {

    var privacy = privacy
        set(value) = when (privacy) {
            0, 1, 2, 3 -> field = privacy
            else -> field = 0
        }

    var commentPrivacy = commentPrivacy
        set(value) = when (commentPrivacy) {
            0, 1, 2, 3 -> field = commentPrivacy
            else -> field = 0
        }
}
