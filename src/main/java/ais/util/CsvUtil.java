package ais.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import ais.dto.KarteKasidasiDto;

public class CsvUtil {

	public static void main(String[] args) {
		List<KarteKasidasiDto> dataList = importKasidasiCSV("C:\\Users\\yuki\\Desktop\\Java関係\\pleiades\\workspace\\ais2\\data\\kasidasi.csv");

		for(KarteKasidasiDto data : dataList) {
			System.out.println(data.getName());
		}
	}

	public static List<KarteKasidasiDto> importKasidasiCSV(String path) {
		List<KarteKasidasiDto> dataList = new ArrayList<>();

		try(BufferedReader br = new BufferedReader(new FileReader(path));) {
			while(br.ready()) {
				String row = br.readLine();
				String[] cols = row.split(",");
				KarteKasidasiDto dto = new KarteKasidasiDto();
				dto.setId(cols[0]);
				dto.setKarteNo(cols[1]);
				dto.setName(cols[2]);
				dto.setKana(cols[3]);
				dto.setKaMei(cols[4]);
				dto.setNyuinDate(cols[5]);
				dto.setTaiinDate(cols[6]);
				dto.setTeisyutu(cols[7]);
				dto.setKasidasi(cols[8]);
				dto.setBirth(cols[9]);
				dto.setAge(cols[10]);
				dto.setGender(cols[11]);
				dto.setHenkyakuDate(cols[12]);
				dto.setHannyuDate(cols[13]);
				dataList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}
}