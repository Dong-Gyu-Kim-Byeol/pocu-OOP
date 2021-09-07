package academy.pocu.comp2500.assignment1.app;

public class Program {

    public static void main(String[] args) {
        Blog blog = new Blog("blog 1");

        User author1 = new User("author1");
        User author2 = new User("author2");

        User read1 = new User("read1");

        blog.addPost(author1, "tt11", "bb11");

        read1.visitBlog(blog);

    }
}
