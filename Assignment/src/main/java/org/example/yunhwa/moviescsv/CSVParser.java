package org.example.yunhwa.moviescsv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVParser implements Parser {

    boolean hasDoubleQuotesBefore;
    public List<String> split(String line) {
        List<String> stringList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '"') {
                sb.append(line.charAt(i));

                if (this.hasDoubleQuotesBefore) { // 여기가 이번 값 완성된 끝. 다음이 ; 일 예정
                    this.hasDoubleQuotesBefore = false; // 초기화 해주고
                    continue; // 완성된 스트링 빌더 넣으러 다음으로
                } else {
                    this.hasDoubleQuotesBefore = true;

                    // 여기부터 값 입력 시작
                    if (i == line.length() - 1) {
                        stringList.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            } else if (line.charAt(i) == ';') {
                if (line.charAt(i - 1) == '"') {
                    // 이전까지 담긴 스트링 빌더가 완성된 값!
                    stringList.add(sb.toString());
                    sb.setLength(0);
                    this.hasDoubleQuotesBefore = false;

                } else if (this.hasDoubleQuotesBefore) {
                    sb.append(line.charAt(i));
                    if (i == line.length() - 1) {
                        stringList.add(sb.toString());
                        sb.setLength(0);
                    }
                } else {
                    // 이전까지 담긴 스트링 빌더가 완성된 값!
                    stringList.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(line.charAt(i));
                if (i == line.length() - 1) {
                    stringList.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        return stringList;
    }

    @Override
    public List<Movie> parse(String path) {
        List<Movie> parsedDatas = new ArrayList<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path));) {
            // 대상 csv 파일의 경로 파라미터로 들어온 값 path 로 설정

            // csv 파일에서 읽어들인 1행분의 데이터
            String line = "";

            line = bufferedReader.readLine(); // 첫 줄 버리기

            boolean isLineSeparated = false;
            List<String> lineContents = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {

                if (isLineSeparated) {
                    List<String> tmpList = split(line);

                    String lastString = lineContents.get(lineContents.size() - 1);
                    if (lastString.charAt(lastString.length() - 1) != ';') {
                        // tmpList의 첫 String을 lastString에 합쳐주자
                        lineContents.remove(lineContents.size() - 1);
                        lineContents.add(lastString.concat(tmpList.get(0)));
                        tmpList.remove(0);
                    }

                    lineContents.addAll(tmpList);

                    isLineSeparated = false;

                } else {
                    // 한 줄 읽어온 걸 ; 구분자로 구분해서 String 배열로 분리
                    lineContents = split(line);
                }


                if (lineContents.size() > 13) {
                    System.out.println("13개의 필드로 나눠지지 않고 더 많이 나눠졌습니다. 이상합니다. 다시 확인해보세요");
                    break;
                } else if (lineContents.size() < 13) {
                    isLineSeparated = true;
                    continue;
                }



                Movie currentMovie = new Movie();

                // csv 파일의 1행을 저장하는 String 배열에 접근
                for (int i = 0; i < lineContents.size(); i++) {

                    if (lineContents.get(i).equals("NULL")) {
                        lineContents.set(i, "0");
                    }

                    switch (i) {
                        case 0:
                            currentMovie.setMovieID(Integer.parseInt(lineContents.get(i)));
                            break;
                        case 1:
                            currentMovie.setTitle(deleteDoubleQuotes(lineContents.get(i)));
                            break;
                        case 2:
                            currentMovie.setKoreanTitle(deleteDoubleQuotes(lineContents.get(i)));
                            break;
                        case 3:
                            currentMovie.setPlot(deleteDoubleQuotes(lineContents.get(i)));
                            break;
                        case 4:
                            currentMovie.setReleaseYear(Integer.parseInt(lineContents.get(i)));
                            break;
                        case 5:
                            currentMovie.setRunningTime(Integer.parseInt(lineContents.get(i)));
                            break;
                        case 6:
                            currentMovie.setGradeID(Integer.parseInt(lineContents.get(i)));
                            break;
                        case 7:
                            currentMovie.setGradeInKoreanID(Integer.parseInt(lineContents.get(i)));
                            break;
                        case 8:
                            currentMovie.setPoster(lineContents.get(i));
                            break;
                        case 9:
                            Date formatDate;
                            if (lineContents.get(i).equals("0")) {
                                formatDate = new Date(0000,00,00);
                                break;
                            } else {
                                String releaseDateStr = lineContents.get(i);
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                formatDate = dateFormat.parse(releaseDateStr);
                                currentMovie.setReleaseDateInKorea(formatDate);
                                break;
                            }
                        case 10:
                            currentMovie.setBoxOfficeWWGross(Long.parseLong(lineContents.get(i)));
                            break;
                        case 11:
                            currentMovie.setBoxOfficeUSGross(Long.parseLong(lineContents.get(i)));
                            break;
                        case 12:
                            currentMovie.setBudget(Long.parseLong(lineContents.get(i)));
                            break;
                        default:
                            System.out.println("switch 문에 이상한 값이 들어온 것 같습니다. Movie Setter 처리가 안되었습니다.");
                    }
                }

                parsedDatas.add(currentMovie);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return parsedDatas;
    }

    public String deleteDoubleQuotes(String inputString) {
        StringBuilder inputSb = new StringBuilder(inputString);

        if (inputSb.length() >= 2 && inputSb.charAt(0) == '"' && inputSb.charAt(inputSb.length() - 1) == '"') {
            inputSb.deleteCharAt(0);
            inputSb.deleteCharAt(inputSb.length() - 1);
        }

        return inputSb.toString();
    }
}