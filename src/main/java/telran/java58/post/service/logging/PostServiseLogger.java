package telran.java58.post.service.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Slf4j(topic = "telran.java58.post.service.PostServiceImpl")
@Aspect
public class PostServiseLogger {
    @Pointcut("execution(public * telran.java58.post.service.PostServiceImpl.*(String)) && args(id)")
            public void findById(String id){}

    @Pointcut("@annotation(telran.java58.post.service.logging.PostLogger)")
    public void annotatePostLogger() {}

        @Before("findById(id)")
                public void logFindById(String id) {
            log.info("find post by id {}", id);
        }

        @AfterReturning("annotatePostLogger()")
                public void logAnnotateLogger(JoinPoint joinPoint) {
            log.info("Annotated by PostLogger method: {}, done", joinPoint.getSignature().getName());
        }

       // @Arround //TODO


    }

