package repo.spring.context;

import beans.*;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import model.*;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class Main
{
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main( String[] args )
    {
        // Use ProjectConfig class when initializing Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Hello, Spring");
        comment.setAuthor("nu1lspaxe");

        service.publishComment(comment);
    }

    private static Supplier<Parrot> getParrotSupplier() {
        Parrot x = new Parrot();
        x.setName("parrotSupplier");
        return () -> x;
    }
}
