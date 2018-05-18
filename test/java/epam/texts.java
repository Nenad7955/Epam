package epam;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum texts {
    link("https://jdi-framework.github.io/tests/index.htm"),
    linkIndex("Index Page"),
    ID("epam"),
    password("1234"),
    userName("PITER CHAILOVSKII"),
    first("To include good practices\nand ideas from successful\nEPAM projec"),
    second("To be flexible and\ncustomizable"),
    third("To be multiplatform"),
    fourth("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"),
    framework("EPAM FRAMEWORK WISHES…"),
    weird("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    String value;
}
