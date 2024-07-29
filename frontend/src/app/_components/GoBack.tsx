import Link from "next/link";
import { IoArrowBack } from "react-icons/io5";

export const GoBack = () => {
  return (
    <Link href="/mascotas">
      <button className="btn btn-active text-white shadow-lg text-2xl px-8 py-4 h-auto">
        <IoArrowBack size={30} />
        <span>Regresar</span>
      </button>
    </Link>
  );
}
