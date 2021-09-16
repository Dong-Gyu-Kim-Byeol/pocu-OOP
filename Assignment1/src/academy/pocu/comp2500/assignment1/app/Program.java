package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.BlogSystemManager;
import academy.pocu.comp2500.assignment1.EPostReaction;
import academy.pocu.comp2500.assignment1.EPostSorting;
import academy.pocu.comp2500.assignment1.Post;
import academy.pocu.comp2500.assignment1.PostComment;
import academy.pocu.comp2500.assignment1.User;

import java.util.HashSet;

public class Program {


    public static void main(String[] args) {
        BlogSystemManager blogSystemManager = new BlogSystemManager();

        Blog blog = new Blog("blog 1");

        User author1 = blog.createUser("author1");
        User author2 = blog.createUser("author2");
        User read1 = blog.createUser("read1");
        User read2 = blog.createUser("read2");

        Post newPost = new Post(author1.getUserId(), author1.getName(), new HashSet<String>(), "tt11", "bb11");
        blog.addPost(newPost);
        newPost.addTag(new String("tag11"));
        newPost.addTag(new String("tag11"));
        newPost.addTag(new String("tag12"));
        newPost.addReaction(read1.getUserId(), EPostReaction.FUN);
        PostComment newComment = new PostComment(read1.getUserId(), read1.getName(), "comment11");
        newPost.addComment(newComment);
        newComment.addSubcomment(new PostComment(read2.getUserId(), read2.getName(), "subcom111"));

        newPost = new Post(author2.getUserId(), author2.getName(), new HashSet<String>(), "tt22", "bb22");
        blog.addPost(newPost);
        newPost.addTag("tag22");
        newComment = new PostComment(read1.getUserId(), read1.getName(), "comment21");
        newPost.addComment(newComment);
        newComment.addSubcomment(new PostComment(read2.getUserId(), read2.getName(), "subcom211"));
        newComment.addSubcomment(new PostComment(read2.getUserId(), read2.getName(), "subcom212"));
        newComment.setBodyCheckIsAuthor(read1.getUserId(), "setbody");

        newComment = new PostComment(read1.getUserId(), read1.getName(), "comment22");
        newPost.addComment(newComment);
        newComment.addSubcomment(new PostComment(read2.getUserId(), read2.getName(), "subcom221"));
        newComment.upvote(read1.getUserId());

        newPost.addReaction(read1.getUserId(), EPostReaction.GREAT);
        newPost.addReaction(read2.getUserId(), EPostReaction.FUN);


        read1.visitBlog(blog);
        newPost.removeReaction(read1.getUserId());

        System.out.println("\n\n------------- Filter ---------------\n");
        blog.setAuthorIdFilter(author2.getUserId());

        var tags = new HashSet<String>();
        tags.add("tag22");
        blog.setTagsFilter(tags);

        blog.setSortingType(EPostSorting.TITLE_ASCENGIND);


        read1.visitBlog(blog);

    }
}
