package com.github.caluml.familytree;

import org.junit.Test;

import static com.github.caluml.familytree.Sex.FEMALE;
import static com.github.caluml.familytree.Sex.MALE;
import static org.assertj.core.api.Assertions.assertThat;

public class InlawTest {

  @Test
  public void Mother_in_law() {
    assertThat(new Me(MALE).spouses().mother()).isEqualTo("mother-in-law");
  }

  @Test
  public void Father_in_law() {
    assertThat(new Me(MALE).spouses().father()).isEqualTo("father-in-law");
  }

  @Test
  public void Brother_in_law() {
    assertThat(new Me(MALE).sisters().spouse(MALE)).isEqualTo("brother-in-law");
  }

  @Test
  public void Sister_in_law() {
    assertThat(new Me(MALE).brothers().spouse(FEMALE)).isEqualTo("sister-in-law");
  }

}
