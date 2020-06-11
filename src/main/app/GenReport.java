package main.app;

import main.data.Stock;
import main.gencorpus.*;

import java.util.LinkedList;
import java.util.List;

public class GenReport {
    Stock stk;

    public GenReport(Stock stock) {
        this.stk = stock;
    }

    public String generateSentences() {
        //Sentences sentence6 = new Sentence6(this.stk);
        List<Sentences> sentences = new LinkedList<>();
        sentences.add(new Sentence1(this.stk));
        sentences.add(new Sentence2(this.stk));
        sentences.add(new Sentence3(this.stk));
        sentences.add(new Sentence4(this.stk));
        sentences.add(new Sentence5(this.stk));
        sentences.add(new Sentence6(this.stk));
        sentences.add(new Sentence7(this.stk));
        sentences.add(new Sentence8(this.stk));
        sentences.add(new Sentence9(this.stk));


        String corpus = "<b>" + stk.toString() + ":</b><br/>";

        for (Sentences s : sentences) {
            corpus = corpus.concat(s.genSentence());
            corpus = corpus.concat("<br/>");
        }

        return corpus;
    }

}
