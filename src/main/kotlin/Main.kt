    data class Post(
        val id: Int?,
        val ownerId: Int? = null,
        val fromId: Int? = null,
        val createdBy: Int? = null,
        val date: Int? = null,
        val text: String? = null,
        val replyOwnerId: Int? = null,
        val replyPostId: Int? = null,
        val friendsOnly: Boolean? = null,
        val comments: Comments? = null,
        val copyright: Copyright? = null,
        val likes: Likes? = null,
        val reposts: Reposts? = null,
        val views: Views? = null,
        val postType: String? = null,
        val signerId: Int? = null,
        val canPin: Boolean? = null,
        val canDelete: Boolean? = null,
        val canEdit: Boolean? = null,
        val isPinned: Boolean? = null,
        val markedAsAds: Boolean? = null,
        val isFavorite: Boolean? = null,
        val donut: Donut? = null,
        val postponedId: Int? = null
    ) {


    }

    class Placeholder {
    }

    class Reposts(
        val count: Int,
        val userReposted: Boolean
    ) {
    }

    class Views(
        val count: Int
    ) {
    }

    class Comments(
        val count: Int,
        val canPost: Boolean,
        val groupsCanPost: Boolean,
        val canClose: Boolean,
        val canOpen: Boolean
    ) {
    }

    class Copyright(
        val id: Int,
        val link: String,
        val name: String,
        val type: String
    ) {
    }

    class Donut(
        val isDonut: Boolean,
        val paidDuration: Int,
        val placeholder: Placeholder,
        val canPublishFreeCopy: Boolean,
        val editMode: String
    ) {
    }

    class Likes(
        val count: Int,
        val userLikes: Boolean,
        val canLike: Boolean,
        val canPublish: Boolean
    ) {
    }

    object WallService {
        private var posts = emptyArray<Post>()

        fun add(post: Post): Post {
            posts += post.copy(id = posts.indexOf(post) + 1)
            return posts.last()
        }

        fun update(post: Post): Boolean {
            for ((index, item) in posts.withIndex()) {
                if (item.id == post.id) {
                    posts[index] = post.copy(id = post.id, date = post.date)
                    return true
                }
            }
            return false
        }
    }

    fun main() {
        val post1 = Post(id = 11)
        val post2 = Post(id = 11, text = "newText")

        WallService.add(post1)

        WallService.update(post2)
    }

