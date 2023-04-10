package com.ait.ServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ait.entity.CitizenPlan;
import com.ait.repository.CitizenPlanRepository;
import com.ait.request.SearchRequest;
import com.ait.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public List<String> getPlanNames() {
		List<String> planNames = repo.getPlanNames();
		return planNames;
	}

	@Override
	public List<String> getPlanStatuses() {
     List<String> planStatuses = repo.getPlanStatuses();
		return planStatuses;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		
		if(null!=request.getPLAN_NAME() && !"".equals(request.getPLAN_NAME())) {
			entity.setPLAN_NAME(request.getPLAN_NAME());
		}
		
		if(null!=request.getPLAN_STATUS() && !"".equals(request.getPLAN_STATUS())) {
			entity.setPLAN_STATUS(request.getPLAN_STATUS());
		}
		
		if(null!=request.getGENDER() && !"".equals(request.getGENDER())) {
			entity.setGENDER(request.getGENDER());
		}
		
		if(null!=request.getPLAN_START_DATE() && !"".equals(request.getPLAN_START_DATE())) {
			String startdate = request.getPLAN_START_DATE();
			System.out.println("Starting date "+startdate);
			DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			//converting String to LocalDate
			LocalDate localdate = LocalDate.parse(startdate,date);
			System.out.println("local date " +localdate);
			
			entity.setPLAN_START_DATE(localdate);
		}
		
		if(null!=request.getPLAN_END_DATE() && !"".equals(request.getPLAN_END_DATE())) {
			String startdate = request.getPLAN_END_DATE();
			System.out.println("Starting date "+startdate);
			DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			//converting String to LocalDate
			LocalDate localdate = LocalDate.parse(startdate,date);
			System.out.println("local date " +localdate);
			
			entity.setPLAN_END_DATE(localdate);
		}
	     return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportPdf() {

		return false;
	}

	@Override
	public boolean exportExcel() {

		return false;
	}

}
