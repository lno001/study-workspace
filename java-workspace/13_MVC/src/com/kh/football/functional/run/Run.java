package com.kh.football.functional.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.kh.football.functional.model.dto.Material;
import com.kh.football.functional.model.service.BinFilter;
import com.kh.football.functional.model.service.RedFilter;

public class Run {

	public static void main(String[] args) {
		List<Material> bin = new ArrayList<Material>(List.of(
				new Material("건두부", 1000, "흰색"),
				new Material("새우완자", 3000, "빨간색"),
				new Material("청경채", 1500, "초록색"),
				new Material("분모짜", 4000, "흰색"),
				new Material("소고기", 10000, "빨간색"),
				new Material("옥수수면", 3500, "노란색")
				));
		
		BinFilter bf = new RedFilter();
		System.out.println("빨간색 재료");
		for(Material m : bin) {
			if(bf.test(m)) {
				System.out.println(m.getName());
			}
		}
		
		BinFilter yellowFilter = new BinFilter() {

			@Override
			public boolean test(Material m) {
				return m.getColor().equals("노란색");
			}
		};
		System.out.println("노란색 재료");
		for(Material m : bin) {
			if(yellowFilter.test(m)) {
				System.out.println(m.getName());
			}
		}
		
		BinFilter greenFilter = m -> m.getColor().equals("초록색");
		System.out.println("초록색 재료");
		for(Material m : bin) {
			if(greenFilter.test(m)) {
				System.out.println(m.getName());
			}
		}
		
		BinFilter whiteFilter = m -> m.getColor().equals("흰색");
		System.out.println("흰색 재료");
		for(Material m : bin) {
			if(whiteFilter.test(m)) {
				System.out.println(m.getName());
			}
		}
		
		BinFilter expensiveFilter = m -> m.getPrice() >= 3500;
		
		System.out.println("3500원 이상인 재료");
		for(Material m : bin) {
			if(expensiveFilter.test(m)) {
				System.out.println(m.getName());
			}
		}
		
		// Predicate<T> - 판별 T(타입 아무거나) -> boolean
		Predicate<Material> isRed = m -> m.getColor().equals("빨간색");
		for(Material m : bin) {
			if(isRed.test(m)) {
				System.out.println(m.getName());
			}
		}
		
		// Function<T, R> - 변환 T(타입 아무거나) -> R(리턴타입)
		// 재료 객체를 받아서 재료객체의 이름을 반환
		Function<Material, String> getName = m -> m.getName();
		System.out.println(getName.apply(new Material("돼지고기", 5000, "빨간색")));
		
		// Consumer<T> - 소비 T(타입아무거나) -> void
		Consumer<Material> print = m -> System.out.println(m.getName());
		print.accept(new Material("양고기", 8000, "빨간색"));
		
		// Supplier<T> - 공급
		Supplier<Material> defaultM = () -> new Material("닭고기", 4000, "빨간색");
		Material chicken = defaultM.get();
		print.accept(chicken);
		System.out.println("===========================================");
		List<Material> reds = new ArrayList<Material>();
		for(int i = 0; i < bin.size(); i++) {
			if(bin.get(i).getColor().equals("빨간색")) {
				reds.add(bin.get(i));
			}
		}
		System.out.println(reds);
		System.out.println("===========================================");
		
		List<Material> red = bin.stream().filter(m -> m.getColor().equals("빨간색")).collect(Collectors.toList());
		System.out.println(red);
		System.out.println("===========================================");
		
		// 재료들이 많다. 재료들의 이름만 사용
		
		List<String> names = new ArrayList<String>();
		for(int i = 0; i <bin.size(); i++) {
			names.add(bin.get(i).getName());
		}
		System.out.println(names);
		
		List<String> name = bin.stream().map(m -> m.getName()).collect(Collectors.toList());
		System.out.println(name);
		
		List<String> colors = bin.stream().map(Material::getColor).distinct().collect(Collectors.toList());
		System.out.println(colors);
		
		Set<String> colorSet = bin.stream().map(Material::getColor).distinct().collect(Collectors.toSet());
		System.out.println(colorSet);
		
		String strs = bin.stream().map(Material::getColor).distinct().collect(Collectors.joining(","));
		System.out.println(strs);
		
		Material found = bin.stream().filter(m -> m.getPrice() > 4000).findFirst().orElse(null);
		System.out.println(found);
		
	}

}
