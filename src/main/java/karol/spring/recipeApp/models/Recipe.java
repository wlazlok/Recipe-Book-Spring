package karol.spring.recipeApp.models;


import javax.persistence.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String prepTime;
    private String cookTime;
    private String serving;
    private String source;
    private String url;

    @Lob
    private String direction;

    @Lob
    private Byte[] image;


}
