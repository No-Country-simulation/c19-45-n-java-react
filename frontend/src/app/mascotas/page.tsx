import { Banner, PetGrid, PetSpecies, ModalFilter } from "@/components";

export interface IPetParams {
  SEX: string;
  NAME: string;
  SPECIE_ID: string;
}
interface IParams {
  searchParams: IPetParams;
}

const PagePets = ({ searchParams }: IParams) => {
  return (
    <>
      <Banner />
      <PetSpecies currentSpecie={searchParams.SPECIE_ID} />
      <PetGrid
        SEX={searchParams.SEX}
        NAME={searchParams.NAME}
        SPECIE_ID={searchParams.SPECIE_ID}
      />
      <ModalFilter />
    </>
  );
};

export default PagePets;
