package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.EPostReaction;
import academy.pocu.comp2500.assignment1.EPostSorting;
import academy.pocu.comp2500.assignment1.Post;
import academy.pocu.comp2500.assignment1.PostComment;
import academy.pocu.comp2500.assignment1.User;

import java.util.HashSet;
import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {
        Blog blog = new Blog("blog 1");

        User author1 = new User("author1");
        User author2 = new User("author2");
        User read1 = new User("read1");
        User read2 = new User("read2");
        Post newPost = new Post(author1, new HashSet<String>(), "tt11", "bb11");
        blog.addPost(newPost);
        newPost.addTag(author1, "tag11");
        newPost.addReaction(read1, EPostReaction.FUN);
        PostComment newComment = new PostComment(read1, "comment11");
        newPost.addComment(newComment);
        newComment.addSubcomment(new PostComment(read2, "subcom111"));

        newPost = new Post(author2, new HashSet<String>(), "tt22", "bb22");
        blog.addPost(newPost);
        newPost.addTag(author2, "tag22");
        newComment = new PostComment(read1, "comment21");
        newPost.addComment(newComment);
        newComment.addSubcomment(new PostComment(read2, "subcom211"));
        newComment.addSubcomment(new PostComment(read2, "subcom212"));

        newComment = new PostComment(read1, "comment22");
        newPost.addComment(newComment);
        newComment.addSubcomment(new PostComment(read2, "subcom221"));
        newComment.upvote(read1);

        newPost.addReaction(read1, EPostReaction.GREAT);
        newPost.addReaction(read2, EPostReaction.FUN);


        read1.visitBlog(blog);
        newPost.deleteReaction(read1);

        System.out.println("\n\n------------- Filter ---------------\n");
        read1.setAuthorFilterOrNull(author2);

        var tags = new HashSet<String>();
        tags.add("tag22");
        read1.setTagFilters(tags);

        read1.setPostSorting(EPostSorting.TITLE_ASCENGIND);


        read1.visitBlog(blog);

    }
}
