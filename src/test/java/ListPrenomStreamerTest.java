import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;


public class ListPrenomStreamerTest {

    @Test
    public void size_should_be_10() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");

        // Then
        assertThat(listPrenomStreamer.getSize(), is(28));
    }
    
    @Test
    public void top_3_2010() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        List<String> top32010 = listPrenomStreamer.top3name2010();
        // Then
        assertThat(top32010, contains("Patrick", "Ben", "Gerard"));
    }
    
    @Test
    public void top_3_girl_name() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        
        List<String> top3GirlNameIn2009 = listPrenomStreamer.top3NameByGenderAndYear("F", 2009);

        // Then
        assertThat(top3GirlNameIn2009, contains("Alexia","Victoria","Eve"));
    }
    
    @Test
    public void top_3_boy_name() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        
        List<String> top3GirlNameIn2009 = listPrenomStreamer.top3NameByGenderAndYear("M", 2012);

        // Then
        assertThat(top3GirlNameIn2009, contains("Martin","Philippe","Jhon"));
    }
    
    @Test
    public void top_5_2009_to_2016() throws Exception {
    	// Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        List<String> top5name2009to2016 = listPrenomStreamer.top5name2009to2016();
        // Then
        assertThat(top5name2009to2016, contains("Sandra93","Patrick", "Martin", "Ben", "Adam"));
    }
    
    @Test
    public void top_10_worst_2009_to_2016() throws Exception {
    	// Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        List<String> top10WorstName2009to2016 = listPrenomStreamer.top10WorstName2009to2016();
        // Then
        assertThat(top10WorstName2009to2016, contains("Alexandrine","Fatima","Angelique","Alexandra","Marine","Eve", "Jhon", "Ibrahim", "Ma�l", "Baptiste"));
    }
    
    @Test
    public void top_12_worst_girl_2016() throws Exception {
    	// Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        List<String> top12WorstGirlName2016 = listPrenomStreamer.top12WorstGirl2016();
        // Then
        assertThat(top12WorstGirlName2016, contains("Alexandrine","Fatima","Angelique","Alexandra","Marine","Filipini","Rose","Sandra93"));
    }
    
    @Test
    public void namesByGender() throws Exception {
    	// Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        Map<String,List<String>> genderNamesMap = listPrenomStreamer.namesByGenre();
        // Then
        assertThat(genderNamesMap.get("M").size(), is(17));
        assertThat(genderNamesMap.get("F").size(), is(19));
    }
    
    @Test
    public void best5ByYear() throws Exception {
    	// Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        Map<Integer, Map<String, Integer>> best5 = listPrenomStreamer.best5Letters();

        // Then
        assertThat(best5.get(2016).size(), Matchers.lessThan(6));
        assertThat(best5.get(2016).keySet().toArray()[0], is("S"));//first in 2016
        assertThat(best5.get(2016).keySet().toArray()[1], is("B"));//second etc...
        assertThat(best5.get(2016).keySet().toArray()[2], is("A"));
        assertThat(best5.get(2016).keySet().toArray()[3], is("R"));
        assertThat(best5.get(2016).keySet().toArray()[4], is("V"));
    }



    @Test
    public void nameAppearFrom2009To2016() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        List<String> nameAppearFrom2009To2016 = listPrenomStreamer.nameAppearFrom2009To2016();
        // Then
        assertThat(nameAppearFrom2009To2016, contains("A"));
    }

}