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
          name={pet.name}
          picture={pet?.photo}
          age={pet.age}
          specie={pet.breed}
          sex={pet.sex}
        />
        <Contact name={pet.owner.name} email={pet.owner.email} />
        <PetPictures pictures={pet.additionalPhotos} />
      </>
    );
  }
};
