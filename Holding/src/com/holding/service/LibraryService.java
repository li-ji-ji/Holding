package com.holding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.holding.po.Library;
import com.holding.vm.LibraryPercentageVm;
import com.holding.vm.LibraryChildVm;

@Service
public interface LibraryService {
	
	public List<LibraryPercentageVm> getLibraryPercentageVmList(int provinceId,int cityId) throws Exception;
	
	public LibraryChildVm getLibraryVmById(int libraryId,int floorId,int roomId,int deskId,int seatId);

	public Map<String, Object> insertLibrary(Library library) throws SQLException;
	
	public Map<String, Object> deleteLibrary(List<Integer> libraryIds) throws SQLException;
	
	public Map<String, Object> updateLibrary(Library library) throws SQLException;
}
