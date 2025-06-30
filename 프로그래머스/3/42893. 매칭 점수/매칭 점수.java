import java.util.regex.*;
import java.util.*;

class Solution {
    
    class Page {
        int idx;
        String url;
        List<String> outLinks;
        int baseScore;
        double linkScore = 0.0;
    }
    
    public int solution(String word, String[] pages) {
        int n = pages.length;
        Map<String, Page> urlToPage = new HashMap<>();
        Page[] pageArr = new Page[n];
        word = word.toLowerCase();
        
        for (int i = 0; i < n; i++) {
            String html = pages[i];
            Page page = new Page();
            page.idx = i;
            page.url = extractUrl(html);
            page.outLinks = extractLinks(html);
            String bodyText = plainText(extractBody(html)).toLowerCase();
            page.baseScore = countMatch(word, bodyText);
            pageArr[i] = page;
            urlToPage.put(page.url, page);
        }
        
        for (Page page : pageArr) {
            int nOut = page.outLinks.size();
            if (nOut == 0) continue;
            double sendScore = (double) page.baseScore / nOut;
            
            for (String out : page.outLinks) {
                Page outPage = urlToPage.get(out);
                if (outPage != null) {
                    outPage.linkScore += sendScore;
                }
            }
        }
        
        int answer = 0;
        double maxScore = 0;
        for (int i = 0; i < n; i++) {
            double totalScore = pageArr[i].baseScore + pageArr[i].linkScore;
            if (totalScore > maxScore) {
                maxScore = totalScore;
                answer = i;
            }
        }
        
        return answer;
    }
    
    public String extractBody(String html) {
        Pattern bodyPattern = Pattern.compile("(?i)<body.*?>([\\s\\S]*?)</body>");
        Matcher bodyMatcher = bodyPattern.matcher(html);
        String bodyText = "";
        
        if (bodyMatcher.find()) {
            bodyText = bodyMatcher.group(1);
        }
        
        return bodyText;
    }
    
    public String plainText(String bodyText) {
        bodyText = bodyText.replaceAll("<[^>]+>", " ");  
        bodyText = bodyText.replaceAll("\\s+", " ");  
        bodyText = bodyText.trim();   
        
        return bodyText;
    }
    
    public int countMatch(String word, String bodyText) {
        int cnt = 0;
        String[] tokens = bodyText.split("[^a-zA-Z]+");
        
        for (String token : tokens) if (token.equals(word)) cnt++;
        
        return cnt;
    }
    
    public String extractUrl(String html) {
        Pattern urlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(.*?)\"");
        Matcher urlMatcher = urlPattern.matcher(html);
        if (urlMatcher.find()) return urlMatcher.group(1);
        return "";
    }
    
    public List<String> extractLinks(String html) {
        List<String> list = new ArrayList<>();
        Pattern linkPattern = Pattern.compile("<a href=\"(.*?)\"");
        Matcher linkMatcher = linkPattern.matcher(html);
        while (linkMatcher.find()) {
            list.add(linkMatcher.group(1));
        }
        return list;
    }
}