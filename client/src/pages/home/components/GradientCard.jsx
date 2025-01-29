import React, { useEffect, useState } from "react";
import { Vibrant } from "node-vibrant/browser";

export const GradientCard = ({ children, image, isLoading }) => {
  const [gradient, setGradient] = useState("");

  useEffect(() => {
    const imgSrc = image;

    Vibrant.from(imgSrc)
      .getPalette()
      .then((palette) => {
        const vibrantSwatch = palette.Vibrant;
        const darkMutedSwatch = palette.DarkMuted;
        if (vibrantSwatch && darkMutedSwatch) {
          setGradient(
            `linear-gradient(to right, rgb(${vibrantSwatch._rgb.join(",")}), rgb(${darkMutedSwatch._rgb.join(",")}))`,
          );
        }
      })
      .catch((err) => console.error(err));
  }, []);

  return (
    <div>
      <div
        style={{
          background: gradient,
        }}
        className="rounded-3xl cursor-pointer w-full h-full p-4"
      >
        {children}
      </div>
    </div>
  );
};
