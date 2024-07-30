import classNames from "classnames";
import Image from "next/image";
import { IoLogoGithub, IoLogoLinkedin } from "react-icons/io5";

interface IMember {
  name: string;
  role: string;
  github: string;
  linkedin: string;
  image?: string;
  active?: boolean;
}

export const Member = ({
  name,
  role,
  github,
  linkedin,
  image,
  active,
}: IMember) => {
  const classes = classNames(
    "bg-[#FFCD82] p-6 rounded-lg shadow-lg w-full flex flex-col items-center"
  );
  return (
    <div className={classes}>
      <div className="avatar mb-4">
        <div className="w-20 rounded-full">
          <Image
            src={image ? `/members/${image}` : "/members/avatar.jpg"}
            width={80}
            height={80}
            alt={name}
          />
        </div>
      </div>
      <div className="flex gap-4 items-center">
        {github && (
          <a href={github} target="_blank">
            <IoLogoGithub size={35} className="cursor-pointer" />
          </a>
        )}
        {linkedin && (
          <a href={linkedin} target="_blank">
            <IoLogoLinkedin size={35} className="cursor-pointer" />
          </a>
        )}
      </div>
      <div className="p-4 text-center">
        <p className="text-2xl font-semibold">{name}</p>
        <p className="text-gray-800">{role}</p>
      </div>
    </div>
  );
};
