import Image from "next/image";
import Link from "next/link";
import { IoIosFemale } from "react-icons/io";
import { IoIosMale } from "react-icons/io";
import { IoArrowForward } from "react-icons/io5";
import { PET_SEX } from "@/constants";

export interface IPet {
  name: string;
  sex: string;
  age: string;
  picture: string;
  id: number;
}

export const Pet = ({ name, sex, age, picture, id }: IPet) => {
  return (
    <aside className="p-6 bg-[#FFCD82] rounded-lg shadow-lg w-full">
      <Image
        src={picture}
        width={100}
        height={100}
        alt="Mascota"
        className="shadow-lg w-full h-[240px] object-cover rounded-lg bg-[#FFE2B6]"
      />
      <div className="flex justify-between items-center mb-2 mt-6">
        <p className="text-3xl font-bold">{name}</p>
        <div className="bg-[#FFAC31] border-2 border-black p-3 rounded-full">
          {sex == PET_SEX.FEMALE && <IoIosFemale size={22} />}
          {sex == PET_SEX.MALE && <IoIosMale size={22} />}
        </div>
      </div>
      <p className="text-2xl mb-4">{age}</p>
      <Link
        href={`/mascotas/${id}`}
        className="btn btn-active text-white btn-lg shadow-lg text-xl px-8 w-full"
      >
        <span>Conocer</span>
        <IoArrowForward size={30} />
      </Link>
    </aside>
  );
};
