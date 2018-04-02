package com.github.caluml.familytree;

import org.junit.Test;

import static com.github.caluml.familytree.Sex.MALE;
import static org.assertj.core.api.Assertions.assertThat;

public class AncestorTest {

  @Test
  public void Mother() {
    assertThat(new Me(MALE).mother()).isEqualTo("mother");
  }

  @Test
  public void Father() {
    assertThat(new Me(MALE).father()).isEqualTo("father");
  }


  @Test
  public void Mothers_mother() {
    assertThat(new Me(MALE).mothers().mother()).isEqualTo("grand-mother");
  }

  @Test
  public void Mothers_father() {
    assertThat(new Me(MALE).mothers().father()).isEqualTo("grand-father");
  }

  @Test
  public void Fathers_mother() {
    assertThat(new Me(MALE).fathers().mother()).isEqualTo("grand-mother");
  }

  @Test
  public void Fathers_father() {
    assertThat(new Me(MALE).fathers().father()).isEqualTo("grand-father");
  }


  @Test
  public void Great_grandmother() {
    assertThat(new Me(MALE).mothers().fathers().mother()).isEqualTo("great-grand-mother");
  }

  @Test
  public void Great_grandfather() {
    assertThat(new Me(MALE).mothers().fathers().father()).isEqualTo("great-grand-father");
  }

}
