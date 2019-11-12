package schultz.dustin.io.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UploadController {
	
	@Value("${multipart.location}")
	private String location;
	
	@RequestMapping(value="/upload",method = RequestMethod.POST, produces = MediaType.IMAGE_GIF_VALUE)
	public String upload(@RequestPart("file") MultipartFile file,@RequestPart("start") int start,@RequestPart("end") int end,
			@RequestPart("speed") int speed,@RequestPart("repeat") Boolean repeat) throws Exception
	{
		File videoFile = new File(location+"/"+System.currentTimeMillis()+".mp4");
		file.transferTo(videoFile);
		System.out.println("file has been saved successfully"+videoFile);
				
		return "";
	}

}
