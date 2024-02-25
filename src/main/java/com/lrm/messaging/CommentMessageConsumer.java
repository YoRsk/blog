package com.lrm.messaging;

import com.lrm.service.BlogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service//not sure
public class CommentMessageConsumer {
    private final BlogService blogService;

    public CommentMessageConsumer(BlogService blogService) {
        this.blogService = blogService;
    }

    @RabbitListener(queues = "commentQueue")
    public void processMessage(String message) {
        System.out.println("Received comment message: " + message);
        //TODO: update comment count
        //blogService.updateCommentCount(message);
    }
}
