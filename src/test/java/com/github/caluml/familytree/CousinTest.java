package com.github.caluml.familytree;

import org.junit.Test;

import static com.github.caluml.familytree.Sex.MALE;
import static org.assertj.core.api.Assertions.assertThat;

public class CousinTest {

  // Based on https://en.wikipedia.org/wiki/File:CousinTree.svg

  @Test
  public void Male_cousin() {
    assertThat(new Me(MALE).mothers().brothers().son()).isEqualTo("first-cousin");
  }

  @Test
  public void Female_cousin() {
    assertThat(new Me(MALE).mothers().brothers().daughter()).isEqualTo("first-cousin");
  }

  @Test
  public void Male_second_cousin() {
    assertThat(new Me(MALE).mothers().mothers().brothers().daughters().son()).isEqualTo("second-cousin");
  }

  @Test
  public void Female_second_cousin() {
    assertThat(new Me(MALE).mothers().mothers().brothers().daughters().daughter()).isEqualTo("second-cousin");
  }

  @Test
  public void Male_third_cousin() {
    assertThat(new Me(MALE).mothers().mothers().mothers().brothers().daughters().daughters().son()).isEqualTo("third-cousin");
  }

  @Test
  public void Female_third_cousin() {
    assertThat(new Me(MALE).mothers().mothers().mothers().brothers().daughters().daughters().daughter()).isEqualTo("third-cousin");
  }


  @Test
  public void Male_first_cousin_once_removed() {
    assertThat(new Me(MALE).mothers().brothers().daughters().son()).isEqualTo("first-cousin-once-removed");
  }

  @Test
  public void Female_first_cousin_once_removed() {
    assertThat(new Me(MALE).mothers().brothers().daughters().daughter()).isEqualTo("first-cousin-once-removed");
  }

  @Test
  public void Male_second_cousin_once_removed() {
    assertThat(new Me(MALE).mothers().mothers().brothers().daughters().daughters().son()).isEqualTo("second-cousin-once-removed");
  }

  @Test
  public void Female_second_cousin_once_removed() {
    assertThat(new Me(MALE).mothers().mothers().brothers().daughters().daughters().daughter()).isEqualTo("second-cousin-once-removed");
  }


  @Test
  public void Male_first_cousin_twice_removed() {
    assertThat(new Me(MALE).mothers().brothers().daughters().daughters().son()).isEqualTo("first-cousin-twice-removed");
  }

  @Test
  public void Female_first_cousin_twice_removed() {
    assertThat(new Me(MALE).mothers().brothers().daughters().daughters().daughter()).isEqualTo("first-cousin-twice-removed");
  }

//  @Test
//  public void Third_cousin_once_removed() {
//    assertThat(new Me(MALE).mothers().mothers().brothers().daughters().daughters().daughters().daughter()).isEqualTo("third-cousin-once-removed");
//  }

}
