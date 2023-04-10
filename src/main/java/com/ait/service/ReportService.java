package com.ait.service;

import java.util.List;

import com.ait.entity.CitizenPlan;
import com.ait.request.SearchRequest;

public interface ReportService {

	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportPdf();
	
	public boolean exportExcel();
	
}
