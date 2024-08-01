import { petById } from "@/actions/pets";
import { BannerPet, Contact, PetPictures } from ".";

interface IPetBig {
  id: number;
}

export const PetBig = async ({ id }: IPetBig) => {
  const { isOk, pet } = await petById(id);
  if (isOk) {
    return (
      <>
        <BannerPet
          name={pet.nombre}
          picture={pet.fotoPrincipalUrl}
          age={pet.edad}
          specie={pet.raza}
          sex={pet.sexo}
        />
        <Contact />
        <PetPictures pictures={pet.fotosExtra} />
      </>
    );
  }
};
