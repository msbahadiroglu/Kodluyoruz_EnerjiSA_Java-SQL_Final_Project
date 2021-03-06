package com.example.demo;

import com.example.demo.DomainObject.SingerDomain;
import com.example.demo.DomainObject.SongDomain;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.Column;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void TestGetAllSingers() throws Exception{
		mockMvc.perform(get("/FinalProject/v1/singers")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[*].id").exists())
				.andExpect(jsonPath("$[*].name").exists())
				.andExpect(jsonPath("$[*].surname").exists())
				.andExpect(jsonPath("$[*].birth_year").exists());

	}

	@Test
	public void TestGetSingerByID() throws Exception{
		String singerID = "4";


		mockMvc.perform(get("/singers/{singerID}", singerID)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists());


	}

	@Test
	public void TestCreateSinger() throws Exception{
		SingerDomain newSinger = new SingerDomain();
		SongDomain newSong = new SongDomain();

		newSinger.setId(1);
		newSinger.setName("Seyfullah");
		newSinger.setSurname("Bahadiroglu");
		newSinger.setBirth_year(1995);
		newSinger.setSong(newSong);

		newSong.setName("Deneme");
		newSong.setAlbum("Deneme1");
		newSong.setRelease_year("1995");



		mockMvc.perform(post("/singers")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newSinger)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.surname").exists())
				.andExpect(jsonPath("$.birth_year").exists())
				.andExpect(jsonPath("$.song.name").exists())
				.andExpect(jsonPath("$.song.album").exists());

	}

	@Test
	public void TestDeleteSinger() throws Exception{
	String singerID = "1";
	mockMvc.perform(delete("/singers/{singerID}", singerID)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	////Yukarıda 2 testi doğru calıstıramadıgım icin asagıdaki testleri doldurmadım.
	@Test
	public void TestUpdateSinger() throws Exception {
	}

		public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}

