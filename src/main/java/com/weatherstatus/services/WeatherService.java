package com.weatherstatus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.weatherstatus.model.Note;

public class WeatherService {
	private static final Logger logger = LogManager.getLogger(WeatherService.class.getName());	

	@Autowired
	DataSource datasource;
	@Autowired
	RestTemplate restTemplate;

	/*
	 * public static void main(String[] args) {
	 * System.out.println(getTemperature()); }
	 */
	@SuppressWarnings("finally")
	public String getTemperature() {
		try {
			final String uri = "http://api.openweathermap.org/data/2.5/weather?q=Cairo&appid=792ee0c541b473e3fa8eb96e2164a312";
			// String result =
			// "{\"temp\":21.74,\"temp_min\":20.16,\"temp_max\":21.74,\"pressure\":1016.16,\"sea_level\":1029.74,\"grnd_level\":1016.16,\"humidity\":47,\"temp_kf\":1.58}";
			String result = restTemplate.getForObject(uri, String.class);
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(result, JsonObject.class);
			double temp = Double.parseDouble(jsonObject.get("temp").getAsString());
			return temp + "";
		} catch (Exception e) {
			logger.error("inside getTemperature " + e);

		//	throw new Exception("kindly check your firewall settings ");
		}
		finally {
			return "25";
		}

	}

	public void updateNote(String status, String note) {
		String sql_user = "update notes set note =\""+note+"\" where status=\""+status+"\"";
		try {
			logger.info("update notes set note =\""+note+"\" where status=\""+status+"\"");
			getJdbcTemplate().update(sql_user);
		} catch (Exception e) {
			logger.error("inside updateNote " +e);
		}
	}

	@SuppressWarnings("rawtypes")
	public List<Note> findAll()  {
		logger.info("inside findAll ");
		logger.info("select * from notes");

		String sql = "select * from notes";
		String temp = getTemperature();
		List<Note> Notes = new ArrayList<Note>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map row : rows) {
			Note Note = new Note();
			Note.setNote((String) (row.get("note")));
			Note.setStatus((String) row.get("status"));
			Note.setCreateDate(""+ row.get("createdate"));
			Note.setTemperature(temp);
			Notes.add(Note);
		}
		
		return Notes;
	}

	public Note getSelectedOne() {
		List<Note> notes=findAll();
		logger.info("inside getSelectedOne");

		double temp = Double.parseDouble(notes.get(0).getTemperature());
		if (1 < temp && temp <= 10)
			return notes.get(0);
		else if (10 < temp && temp <= 15)
			return notes.get(1);
		else if (15 < temp && temp <= 20)
			return notes.get(2);
		else
			return notes.get(3);

	}

	private JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		return jdbcTemplate;
	}
}
