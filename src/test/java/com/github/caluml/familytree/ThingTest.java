package com.github.caluml.familytree;

import org.junit.Test;

import static com.github.caluml.familytree.Sex.MALE;
import static org.assertj.core.api.Assertions.assertThat;

public class ThingTest {

  @Test
  public void Uncle() {
    assertThat(new Me(MALE).mothers().brother()).isEqualTo("uncle");
  }

  @Test
  public void Nephew() {
    assertThat(new Me(MALE).sisters().son()).isEqualTo("nephew");
  }

  @Test
  public void Brothers_father() {
    assertThat(new Me(MALE).brothers().father()).isEqualTo("father");
  }

//  @Test
//  public void Stepbrothers_father() {
//    assertThat(new Me(MALE).stepbrothers().father()).isEqualTo("??");
//  }

}
