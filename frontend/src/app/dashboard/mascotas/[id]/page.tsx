import Link from "next/link";
import { IoArrowBackOutline } from "react-icons/io5";
import { FormPetBasic, FormPetHealth, FormPetPictures } from "@/components";

const PageDashboardPet = () => {
  const isAdd = true;
  return (
    <>
      <div className="flex gap-4 mb-6">
        <Link href="/dashboard/mascotas">
          <IoArrowBackOutline size={45} />
        </Link>
        <h1 className="text-5xl font-bold">
          {isAdd ? "Crear" : "Editar"}
          Mascota
        </h1>
      </div>
      <FormPetBasic />
      <div className="w-full h-1 bg-black rounded-md" />
      <FormPetHealth />
      <FormPetPictures />
      <div className="flex justify-end">
        <button
          type="button"
          className="btn btn-active text-white btn-lg w-56 shadow-lg text-2xl"
        >
          <p>{isAdd ? "Crear" : "Editar"} Mascota</p>
        </button>
      </div>
    </>
  );
};

export default PageDashboardPet;
