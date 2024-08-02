"use client";

import { BtnAdoptPet, GoBack, ModalAdoptPet, PetBig } from "@/components";
import { useParams } from "next/navigation";

const PagePet = () => {
  const params = useParams();
  const petId = +params.id;
  if (petId) {
    return (
      <>
        <GoBack />
        <PetBig id={petId} />
        <BtnAdoptPet />
        <ModalAdoptPet />
      </>
    );
  }
};

export default PagePet;
