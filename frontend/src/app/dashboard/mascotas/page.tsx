import { PetLargeGrid } from "@/components";
import Link from "next/link";

const PageDashboardPets = () => {
  return (
    <>
      <div className="flex justify-between">
        <h1 className="text-4xl font-bold">Mis Mascotas</h1>
        <Link
          href="/dashboard/mascotas/0?accion=crear-mascota"
          className="btn btn-active text-white btn-lg shadow-lg text-xl px-8 "
        >
          <span>Crear Mascota</span>
        </Link>
      </div>
      <PetLargeGrid />
    </>
  );
};

export default PageDashboardPets;
