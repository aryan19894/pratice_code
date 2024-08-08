package companyOA.hackerrank.Vitech;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MovieTitlesJS {

    static String[] getMovieTitles(String substr) {
        return null;
//		pageNum = 1;
//	    let url = 'https://jsonmock.hackerrank.com/api/movies/search/?Title=' + substr + "&page=" + pageNum;
//	     https.get(url, (res) => {
//	        res.setEncoding('utf8');
//	        res.on('data', function(body) {
//	            let dataRec = JSON.parse(body);
//	            let movies = dataRec.data;
//	            let totPages = dataRec.total_pages;
//	            let sortArray = [];
//	            movies.map((a) => {
//	              sortArray.push(a.Title)
//	            });
//	            if(totPages < 2) {
//	               sortArray.sort().forEach(element => console.log(element));
//	               sortArray = [];
//	            }
//	            
//	            for (let i = 2; i <= totPages; i++) {
//	                let newPage = i;
//	                let url1 = 'https://jsonmock.hackerrank.com/api/movies/search/?Title=' + substr + "&page=" + newPage;
//	                https.get(url1, (res) => {
//	                    res.setEncoding('utf8');
//	                    res.on('data', function(body) {
//	                        let newData = JSON.parse(body);
//	                        let newMovies = newData.data;
//	                        for (let i = 0; i < newMovies.length; i++) {
//	                            sortArray.push(newMovies[i].Title);
//	                        }
//	                        sortArray.sort().forEach(element => console.log(element));
//	                     })
//	                })
//	            }
//	        })
//	    })
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }

        res = getMovieTitles(_substr);
        for (int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

}
