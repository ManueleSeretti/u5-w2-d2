package ManueleSeretti.u5w2d2.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlogPost {
    private long id;
    private String category;
    private String title;
    private String conver;
    private String contenuto;
    private int tempoLettura;

}
