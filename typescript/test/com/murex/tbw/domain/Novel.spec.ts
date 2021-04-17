import { Novel } from "../../../../../src/com/murex/tbw/domain/book/Novel";
import { Language } from "../../../../../src/com/murex/tbw/domain/country/Language";
import { Currency } from "../../../../../src/com/murex/tbw/domain/country/Currency";
import { Country } from "../../../../../src/com/murex/tbw/domain/country/Country";
import { Author } from "../../../../../src/com/murex/tbw/domain/book/Author";
import * as Immutable from "immutable";
import { Genre } from "../../../../../src/com/murex/tbw/domain/book/Genre";
import { EducationalBook } from "../../../../../src/com/murex/tbw/domain/book/EducationalBook";
import { Category } from "../../../../../src/com/murex/tbw/domain/book/Category";

describe(Novel, () => {
  describe("equals", () => {
    const USA = new Country("USA", Currency.Dollar, Language.English);
    const steinbeck = new Author("John Steinbeck", USA);
    const grapesOfWrath = new Novel(
      "Grapes Of Wrath",
      9.99,
      steinbeck,
      Language.English,
      Immutable.Set()
    );
    it("equals itself", () => {
      expect(grapesOfWrath.equals(grapesOfWrath)).toBeTruthy();
      expect(grapesOfWrath.hashCode()).toBe(grapesOfWrath.hashCode());
    });
    it("equals an identical novel", () => {
      const USA2 = new Country("USA", Currency.Dollar, Language.English);
      const steinbeck2 = new Author("John Steinbeck", USA2);
      const grapesOfWrath2 = new Novel(
        "Grapes Of Wrath",
        9.99,
        steinbeck2,
        Language.English,
        Immutable.Set()
      );
      expect(grapesOfWrath.equals(grapesOfWrath2)).toBeTruthy();
      expect(grapesOfWrath.hashCode()).toBe(grapesOfWrath2.hashCode());
    });
    describe("does not equal a novel with a different", () => {
      it("title", () => {
        const anotherNovel = new Novel(
          "Of Mice and Men",
          9.99,
          steinbeck,
          Language.English,
          Immutable.Set()
        );
        expect(grapesOfWrath.equals(anotherNovel)).toBeFalsy();
        expect(grapesOfWrath.hashCode()).not.toBe(anotherNovel.hashCode());
      });
      it("price", () => {
        const anotherNovel = new Novel(
          "Grapes of Wrath",
          6.99,
          steinbeck,
          Language.English,
          Immutable.Set()
        );
        expect(grapesOfWrath.equals(anotherNovel)).toBeFalsy();
        expect(grapesOfWrath.hashCode()).not.toBe(anotherNovel.hashCode());
      });
      it("author", () => {
        const hemingway = new Author("Ernest Hemmingway", USA);
        const anotherNovel = new Novel(
          "Grapes of Wrath",
          9.99,
          hemingway,
          Language.English,
          Immutable.Set()
        );
        expect(grapesOfWrath.equals(anotherNovel)).toBeFalsy();
        expect(grapesOfWrath.hashCode()).not.toBe(anotherNovel.hashCode());
      });
      it("language", () => {
        const anotherNovel = new Novel(
          "Grapes of Wrath",
          9.99,
          steinbeck,
          Language.French,
          Immutable.Set()
        );
        expect(grapesOfWrath.equals(anotherNovel)).toBeFalsy();
        expect(grapesOfWrath.hashCode()).not.toBe(anotherNovel.hashCode());
      });
      it("set of genres", () => {
        const anotherNovel = new Novel(
          "Grapes of Wrath",
          9.99,
          steinbeck,
          Language.English,
          Immutable.Set([Genre.ROMANCE])
        );
        expect(grapesOfWrath.equals(anotherNovel)).toBeFalsy();
        expect(grapesOfWrath.hashCode()).not.toBe(anotherNovel.hashCode());
      });
    });
    describe("only equals true Novel objects", () => {
      it("not another kind of book", () => {
        const badlyCategorizedBook = new EducationalBook(
          "Of Mice and Men",
          9.99,
          steinbeck,
          Language.English,
          Category.LANGUAGE
        );
        expect(grapesOfWrath.equals(badlyCategorizedBook)).toBeFalsy();
        expect(grapesOfWrath.hashCode()).not.toBe(
          badlyCategorizedBook.hashCode()
        );
      });
      it("not any object with identical properties", () => {
        const grapesOfWrath2 = {
          name: "Grapes Of Wrath",
          price: 9.99,
          author: steinbeck,
          language: Language.English,
          genres: Immutable.Set(),
        };
        expect(grapesOfWrath.equals(grapesOfWrath2)).toBeFalsy();
      });
      it("not null", () => {
        expect(grapesOfWrath.equals(null)).toBeFalsy();
      });
      it("not undefined", () => {
        expect(grapesOfWrath.equals(undefined)).toBeFalsy();
      });
    });
  });
});
