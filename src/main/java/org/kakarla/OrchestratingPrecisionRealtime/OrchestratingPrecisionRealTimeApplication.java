package org.kakarla.OrchestratingPrecisionRealtime;

import org.kakarla.OrchestratingPrecisionRealtime.Config.ThreadFactory.ConcurrentNumberThreadFactory;
import org.kakarla.OrchestratingPrecisionRealtime.RealTimeProcessor.lambda.aws.LambdaInvoker;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
public class OrchestratingPrecisionRealTimeApplication {
	 static Integer x = 2;
	 static int y = 2;
	public static void main(String[] args) throws Exception {

//		for (x= 2, y=2 ; x<y; x++) {
//
//		}
//int i = 2;
//		int array[] = {1,2,3};
//		array[0] = 65;
//		System.out.println(array[x++]);
//
//		comparison(getmap(), ( i,  j) -> Objects.equals(i, j));
////		SpringApplication.run(OrchestratingPrecisionRealTimeApplication.class, args);
//		StringBuffer stringBuffer = new StringBuffer("Whiz");
//		stringBuffer.append("labs");
//		stringBuffer.append(".com");
//		stringBuffer.delete(0,  21);
//		System.out.println(x);
////		stringBuffer.insert(1, "f");
////		stringBuffer.replace(0, 31, "f");
////		stringBuffer.delete(0, stringBuffer.capacity());
////		System.out.println(stringBuffer);
//
//		String data = "Tarun you can do it";
////		String data1 = String.format("%1$d < %d", 1,2,3);
//		System.out.println(data);
//		String newdate = data.replaceFirst("\\s", "-");
//		System.out.println(newdate);
//		String[] strings = newdate.split("%d");
//		StringBuffer stringBuffer1 = new StringBuffer();
//
//		for (int i =0; i < strings.length; i++){
//			String value  = strings[i].concat("-hahahhaha.-");
//			stringBuffer1.append(value);
//		}
//		String ne = (stringBuffer1.toString()).join(".", "-", "Wize", "labs");
//
////		System.out.println(LocalDateTime.now().plusDays(4));
//
////		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
////		String text = LocalDate.now().format(dateTimeFormatter);
////		System.out.println(text);
////		LocalDate parsedDate = LocalDate.parse(text, dateTimeFormatter);
////		System.out.println(parsedDate);
//
////		LocalDate localDate = LocalDate.of(6, 02, 29);
////				System.out.println(localDate);
//
//		ArrayList arraysList =  new ArrayList();
//
//		arraysList.add(0, "1");
//		arraysList.add(0);
//		arraysList.add(0, "2");
//		Object value = arraysList.set(0, "3");
//		arraysList.remove(1);
//
//System.out.println(value.toString());
//
//		for (int i=0; i<arraysList.size(); i++) {
////			arraysList.remove(i);
////			System.out.println(arraysList.get(i));
//
//		}

		int i = 0;
		int j = 0;
		int array[][][] = {{{1, 2}, {3, 4}}, {{11, 12}, {13, 14}}, {{22,23}, {24,25}}};
//		System.out.println(array[1][1][1]);

		do {
			i++;
//			System.out.println(i + "i value");
		} while (i < 10);
		{
			do {
				j++;
//				System.out.println(j + "j value");
			} while (j < 8);
		}

//		char charArray[] = new char[3];
//		charArray[0] = 32;
//		charArray[1] = 23;
//		charArray[2] = 33;
//		System.out.println(charArray.length);
//
//		for (i = 1, j= 2; (i < 9 && j < 9); i++, j++) {
//			System.out.println(" value i: " + i + " value j: " + j);
//		}
//
//
//		Map<Integer, Character> map  = new HashMap<>();
//		for(i = 0; i < charArray.length; i++) {
//			map.put(i, charArray[i]);
//		}
//		for (Map.Entry<Integer, Character> var : map.entrySet()) {
//			System.out.println("key:" + var.getKey() + " value: " + var.getValue());
//			if (var.getValue() == 32) {
//				System.out.println("Foundkey:" + var.getKey());
//			}
//		}

		int numberofThreads = 10;
		int numberOfInvocations = 10;
		// Create a custom ThreadFactory with a base name
		ConcurrentNumberThreadFactory threadFactory = new ConcurrentNumberThreadFactory("LambdaInvoker");
		ExecutorService executorService = Executors.newFixedThreadPool(numberofThreads, threadFactory);
		List<Future<String>> futureList = new ArrayList<>();

		for (int x = 0; x<numberofThreads; x++) {
			for (int y = 0; y< numberOfInvocations; y++) {
				LambdaInvoker task = new LambdaInvoker("myfifrstLambda");
				futureList.add(executorService.submit(task));
			}
		}

		// Process the results
		for (Future<String> future : futureList) {
			try {
				String result = future.get();
				System.out.println("Lambda Invocation Result: " + result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		executorService.shutdown();

//		try{



//			System.out.println(args[0]);
//			x.doubleValue();
//			Integer.parseInt(String.valueOf(1.0));
//		} catch (ArithmeticException | NullPointerException exception) {
//			throw new Exception("test");
//		}

//		char array[]  = new char[2];
//		array[0] = 1;
//		array[1] = 2;
//		array[2] = 3;
//
//		System.out.println(array[0]);
//		System.out.println(array[1]);

//		int x = 1;
//		for (x= 0; x<2; x++) {
//			for (int y= 1; x<y; y++) {
//				System.out.println(x+y);
//			}
//		}
	}

	private static Map<Integer, Integer> getmap() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0,2);
		map.put(3,2);
		map.put(1,2);
		return map;
	}

	public static interface NumberComparator {
		public boolean compare(Integer first, Integer second);
	}


	public static <V, K> boolean comparison(Map<Integer, Integer> utilmap, NumberComparator numberComparator) {
		for (Map.Entry<Integer, Integer> entry: utilmap.entrySet()) {
			if (numberComparator.compare(entry.getKey(), entry.getValue())) {
				System.out.println(true);
				return true;
			}
		}
		return false;
	}












}
