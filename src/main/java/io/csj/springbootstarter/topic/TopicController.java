package io.csj.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return Arrays.asList(
				new Topic("s1", "sd1", "sn1"),
				new Topic("s2", "sd2", "sn2"),
				new Topic("s3", "sd3", "sn3")
				);
	}

}
