package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.EPostReaction;
import academy.pocu.comp2500.assignment1.EPostSorting;
import academy.pocu.comp2500.assignment1.Post;
import academy.pocu.comp2500.assignment1.PostComment;
import academy.pocu.comp2500.assignment1.User;

import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        Blog blog = new Blog("blog 1");

        User author1 = new User("author1");
        User author2 = new User("author2");
        User read1 = new User("read1");
        User read2 = new User("read2");

        Post newPost = new Post(author1.getId(), new HashSet<String>(), "tt11", "bb11");
        blog.addPost(newPost);
        newPost.addTag(new String("tag11"));
        newPost.addTag(new String("tag11"));
        newPost.addTag(new String("tag12"));
        newPost.addReaction(read1.getId(), EPostReaction.FUN);
        PostComment newComment = new PostComment(read1.getId(), "comment11");
        newPost.addComment(newComment);
        newComment.addSubcomment(new PostComment(read2.getId(), "subcom111"));

        newPost = new Post(author2.getId(), new HashSet<String>(), "tt22", "bb22");
        blog.addPost(newPost);
        newPost.addTag("tag22");
        newComment = new PostComment(read1.getId(), "comment21");
        newPost.addComment(newComment);
        newComment.addSubcomment(new PostComment(read2.getId(), "subcom211"));
        newComment.addSubcomment(new PostComment(read2.getId(), "subcom212"));

        newComment = new PostComment(read1.getId(), "comment22");
        newPost.addComment(newComment);
        newComment.addSubcomment(new PostComment(read2.getId(), "subcom221"));
        newComment.upvote(read1.getId());

        newPost.addReaction(read1.getId(), EPostReaction.GREAT);
        newPost.addReaction(read1.getId(), EPostReaction.GREAT);
        newPost.addReaction(read2.getId(), EPostReaction.FUN);


        read1.visitBlog(blog);
        newPost.removeReaction(read1.getId(), EPostReaction.GREAT);

        System.out.println("\n\n------------- Filter ---------------\n");
        blog.setAuthorIdFilterOrNull(author1.getId());

        var tags = new HashSet<String>();
        tags.add("tag22");
//        blog.setTagsFilter(tags);

        blog.setSortingType(EPostSorting.TITLE_ASCENGIND);


        read1.visitBlog(blog);

    }
}
