package services;

import aspects.ToLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import repositories.*;
import proxies.*;
import model.*;

import java.util.logging.Logger;

@Service
public class CommentService {


    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void setLogger(Logger logger) { this.logger = logger; }


    @ToLog
    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment.getText());
    }
}
