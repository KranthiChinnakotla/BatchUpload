package com.ampel.drugsearch.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ampel.drugsearch.download.App;
import com.ampel.drugsearch.model.Drug;
import com.ampel.drugsearch.model.Specifications;

public class DrugItemProcessor implements ItemProcessor<Specifications,Specifications>{

	private static final Logger LOG = LoggerFactory.getLogger(Specifications.class);
	private static final String GETDRUG = "select * from DrugTarget where target = ?";
	private static final String GETARGET = "select * from DrugTarget where drug_name = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	List<Drug> drugList;
	String queryString = null;
	
	
	@Override
	public Specifications process(Specifications item) throws Exception {
		// TODO Auto-generated method stub
		final String name = item.getName().toUpperCase();
		final String type = item.getType().toUpperCase();
		if (type.equals("TARGET")) {

			queryString = GETDRUG;

		}
		if (type.equals("DRUG")) {
			queryString = GETARGET;
		}

		if (queryString != null) {
			drugList = jdbcTemplate.query(queryString, new String[] { name }, new RowMapper<Drug>() {

				@Override
				public Drug mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Drug d = new Drug();
					d.setDrug_name(rs.getString(2));
					d.setTarget(rs.getString(3));
					App.queryList.add(d);
					return d;
				}

			});
		}
		if (drugList != null) {
			if (drugList.size() > 0) {
				
				Drug tD = new Drug();
				tD = drugList.get(0);
				final Specifications transformedDrug = new Specifications(tD.getDrug_name()+tD.getTarget(), type);
				return transformedDrug;
				

			} else {
				return null;
			}
		}  
		else {
			return null;
		}
	}

}
