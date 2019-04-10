package com.holding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.holding.po.Library;
import com.holding.vm.LibraryIncludePercentageVm;
import com.holding.vm.LibraryVm;

@Service
public interface LibraryService {

	public List<LibraryIncludePercentageVm> getLibraryIncludePercentageVmList(int provinceId,int cityId);
	
	public List<Library> getLibraryList(int provinceId,int cityId);
	
	public LibraryVm getLibraryVmById(int libraryId,int floorId,int roomId,int deskId,int seatId);

	public Map<String, Object> insertLibrary(Library library) throws SQLException;
	
	public Map<String, Object> deleteLibrary(List<Integer> libraryIds) throws SQLException;
	
	public Map<String, Object> updateLibrary(Library library) throws SQLException;
}
